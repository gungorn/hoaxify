import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

i18n.use(initReactI18next).init({
	resources: {
		en: {
			translations: {
				'Sign Up': 'Sign Up',
				'Password mismatch': 'Password mismatch',
				'Username': 'Username',
				'Display Name': 'Display Name',
				'Password': 'Password',
				'Repeat Password': 'Repeat Password',
				'Login': 'Login'
			}
		},
		tr: {
			translations: {
				'Sign Up': 'Kayıt Ol',
				'Password mismatch': 'Şifreler eşleşmiyor 😜',
				'Username': 'Kullanıcı adı',
				'Display Name': 'Ad soyad',
				'Password': 'Şifre',
				'Repeat Password': 'Şifre tekrarla',
				'Login': 'Giriş Yap'
			}
		},
	},
	fallbackLng: 'tr',
	ns: ['translations'],
	defaultNS: 'translations',
	keySeparator: false,
	interpolation: {
		escapeValue: false,
		formatSeparator: ''
	},
	react: {
		wait: false
	}
});

export default i18n;
